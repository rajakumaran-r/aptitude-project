import { useNavigate } from "react-router-dom";
import "./Topics.css";

const topics = [
  { name: "Age", emoji: "🎂" },
  { name: "ProfitAndLoss", emoji: "💰" },
  { name: "SimpleInterest", emoji: "📈" },
  { name: "WorkAndTime", emoji: "⏱️" },
  { name: "SpeedTimeDistance", emoji: "🚗" },
  { name: "MixtureandAlligation", emoji: "⚗️" },
  { name: "PipesandCistern", emoji: "🚰" },
  { name: "PermutationandCombination", emoji: "🧮" },
  { name: "Random", emoji: "🎲", isRandom: true }, // 👈 NEW
];

export default function Topics() {
  const navigate = useNavigate();

  return (
    <div className="topics-page">
      <h1 className="topics-title">Choose Your Topics</h1>

      <div className="topics-grid">
        {topics.map((t) => (
          <div
            key={t.name}
            className="topic-card"
            onClick={() => navigate(`/questions?topic=${t.name}`)}
          >
            <div className="topic-icon">{t.icon}</div>
            <h3>{t.name.replace(/([A-Z])/g, " $1")}</h3>
            <button>Start Practice </button>
          </div>
        ))}
      </div>
    </div>
  );
}
