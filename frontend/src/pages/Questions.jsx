import { useEffect, useState } from "react";
import { useSearchParams } from "react-router-dom";
import QuestionCard from "../components/QuestionCard";
import { getQuestionsByTopic } from "../api/api";

export default function Questions() {
  const [searchParams] = useSearchParams();
  const topic = searchParams.get("topic");

  const [questions, setQuestions] = useState([]);
  const [loading, setLoading] = useState(true);

  // EXAM STATE
  const [timeLeft, setTimeLeft] = useState(15 * 60);
  const [correct, setCorrect] = useState(0);
  const [answered, setAnswered] = useState(0);
  const [darkMode, setDarkMode] = useState(true);

  // SETTINGS MODAL
  const [showSettings, setShowSettings] = useState(false);

  /* =========================
     FETCH QUESTIONS (FIXED)
  ========================= */
  useEffect(() => {
    async function fetchQuestions() {
      try {
        const res = await getQuestionsByTopic(topic);

        // 🔥 FIX: unwrap axios response safely
        const data = res?.data ?? res;

        console.log("RAW API RESPONSE:", data);

        if (Array.isArray(data)) {
          setQuestions(data);
        } else if (data && typeof data === "object") {
          setQuestions([data]);
        } else {
          setQuestions([]);
        }
      } catch (error) {
        console.error("Failed to fetch questions", error);
        setQuestions([]);
      } finally {
        setLoading(false);
      }
    }

    fetchQuestions();
  }, [topic]);

  /* =========================
     TIMER
  ========================= */
  useEffect(() => {
    if (timeLeft <= 0) return;

    const timer = setInterval(() => {
      setTimeLeft((prev) => prev - 1);
    }, 1000);

    return () => clearInterval(timer);
  }, [timeLeft]);

  /* =========================
     THEME
  ========================= */
  useEffect(() => {
    document.body.classList.toggle("dark", darkMode);
  }, [darkMode]);

  const minutes = Math.floor(timeLeft / 60);
  const seconds = timeLeft % 60;

  if (loading) return <div className="loading">Loading...</div>;

  return (
    <div className="exam-page">
      {/* ================= HEADER ================= */}
      <div className="exam-header">
        {/* LEFT */}
        <button className="theme-toggle" onClick={() => setDarkMode((d) => !d)}>
          {darkMode ? "🌙 Dark" : "☀️ Light"}
        </button>

        {/* CENTER */}
        <h2 className="exam-title">{topic} Questions</h2>

        {/* RIGHT */}
        <div className="header-right">
          <div className="stat">
            ⏱ {minutes}:{seconds.toString().padStart(2, "0")}
          </div>
          <div className="stat">Correct: {correct}</div>
          <div className="stat">Wrong: {Math.max(answered - correct, 0)}</div>
          <button
            className="settings-btn"
            onClick={() => setShowSettings(true)}
          >
            ⚙️
          </button>
        </div>
      </div>

      {/* ================= SETTINGS MODAL ================= */}
      {showSettings && (
        <div className="settings-overlay">
          <div className="settings-panel">
            <h3>Exam Settings</h3>

            <div className="setting-item">
              <label>Timer (minutes)</label>
              <input
                type="number"
                min="1"
                value={Math.max(1, Math.floor(timeLeft / 60))}
                onChange={(e) =>
                  setTimeLeft(Math.max(1, Number(e.target.value)) * 60)
                }
              />
            </div>

            <div className="setting-item">
              <label>Theme</label>
              <button onClick={() => setDarkMode((d) => !d)}>
                {darkMode ? "Switch to Light" : "Switch to Dark"}
              </button>
            </div>

            <button onClick={() => setShowSettings(false)}>Close</button>
          </div>
        </div>
      )}

      {/* ================= QUESTIONS ================= */}
      {questions.length === 0 && <p>No questions found.</p>}

      {questions.map((q, index) => (
        <QuestionCard
          key={q._id || index}
          question={q}
          current={index + 1}
          total={questions.length}
          onAnswer={(isCorrect) => {
            setAnswered((a) => a + 1);
            if (isCorrect) setCorrect((c) => c + 1);
          }}
        />
      ))}
    </div>
  );
}
