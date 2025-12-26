import { useState } from "react";

export default function QuestionCard({ question, current, total, onAnswer }) {
  const [selected, setSelected] = useState(null);
  const [showSolution, setShowSolution] = useState(false);

  const options = Array.isArray(question?.options) ? question.options : [];

  function handleSelect(option) {
    if (selected !== null) return;

    setSelected(option);
    setShowSolution(true);

    onAnswer(option === question.answer);
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
        {options.map((opt, i) => {
          let className = "option-btn";

          if (selected !== null) {
            if (opt === question.answer) className += " correct";
            else if (opt === selected) className += " wrong";
          }

          if (opt === selected) {
            className += " selected";
          }

          return (
            <button
              key={i}
              className={className}
              onClick={() => handleSelect(opt)}
              disabled={selected !== null}
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
