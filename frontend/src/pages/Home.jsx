import "./Home.css";
import { useNavigate } from "react-router-dom";

export default function Home() {
  const navigate = useNavigate();

  return (
    <div className="home-container">
      <div className="home-card">
        <h1 className="home-title">APTITUDE QUIZ</h1>
        <p className="home-subtitle">Platform for Problem Solving</p>

        <button
          className="home-btn-primary"
          onClick={() => navigate("/topics")}
        >
          Initialize Your Game
        </button>
      </div>
    </div>
  );
}
