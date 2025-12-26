import { useEffect, useState } from "react";
import { useSearchParams, useNavigate } from "react-router-dom";
import axios from "axios";
import QuestionCard from "../components/QuestionCard";
import Timer from "../components/Timer";

export default function Quiz() {
  const [params] = useSearchParams();
  const navigate = useNavigate();

  const topic = params.get("topic");
  const mode = params.get("mode"); // random
  const count = params.get("count") || 10;

  const [questions, setQuestions] = useState([]);
  const [index, setIndex] = useState(0);
  const [score, setScore] = useState(0);

  useEffect(() => {
    let url = "";

    if (mode === "random") {
      url = `http://localhost:8080/api/randomQuestions/${count}`;
    } else {
      url = `http://localhost:8080/api/questions?topic=${topic}`;
    }

    axios.get(url).then((res) => {
      setQuestions(res.data);
    });
  }, [topic, mode, count]);

  const handleAnswer = (isCorrect) => {
    if (isCorrect) setScore((s) => s + 1);

    if (index + 1 < questions.length) {
      setIndex(index + 1);
    } else {
      navigate("/result", {
        state: {
          score,
          total: questions.length,
          mode: mode || topic,
        },
      });
    }
  };

  if (!questions.length) return <p>Loading...</p>;

  return (
    <>
      <Timer duration={600} onTimeUp={() => navigate("/result")} />
      <QuestionCard
        question={questions[index]}
        onAnswer={handleAnswer}
        current={index + 1}
        total={questions.length}
      />
    </>
  );
}
