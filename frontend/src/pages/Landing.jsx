import { useNavigate } from "react-router-dom";
import "./Landing.css"; // ✅ file must exist

export default function Landing() {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div className="home-card">
        <h1 className="home-title">APTITUDE QUIZ</h1>
        <p className="home-subtitle">
          Platform for Problem Solving & Exam Practice
        </p>

        <div className="home-actions">
          <button
            className="home-btn-primary"
            onClick={() => navigate("/topics")}
          >
            Initializeeee Your Gameee
          </button>
        </div>
      </div>
    </div>
  );
}
