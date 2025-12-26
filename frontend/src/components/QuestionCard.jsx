import { useState } from "react";

export default function QuestionCard({ question, current, total, onAnswer }) {
  const [selected, setSelected] = useState(null);
  const [showSolution, setShowSolution] = useState(false);

  // ✅ SAFE OPTIONS
  const options = Array.isArray(question?.options) ? question.options : [];

  function handleSelect(option) {
    if (selected) return;

    setSelected(option);
    setShowSolution(true);

    const isCorrect = option === question.answer;
    onAnswer(isCorrect);
  }

  return (
    <div className="question-card">
      {/* META */}
      <div className="question-meta">
        Question {current} / {total}
      </div>

      {/* QUESTION */}
      <div className="question-text">{question.question}</div>

      {/* OPTIONS */}
      <div className="options">
        {options.length === 0 && (
          <p style={{ opacity: 0.6 }}>No options available</p>
        )}

        {options.map((opt, i) => {
          let className = "option-btn";

          if (selected) {
            if (opt === question.answer) className += " correct";
            else if (opt === selected) className += " wrong";
          }

          return (
            <button
              key={i}
              className={className}
              onClick={() => handleSelect(opt)}
              disabled={!!selected}
            >
              {opt}
            </button>
          );
        })}
      </div>

      {/* SOLUTION */}
      {showSolution && question.explanation && (
        <div className="solution">
          <strong>Solution:</strong> {question.explanation}
        </div>
      )}
    </div>
  );
}
