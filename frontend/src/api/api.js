const BASE_URL = import.meta.env.VITE_API_URL;

const topicApiMap = {
  Age: "ages",
  ProfitAndLoss: "profitAndLosses",
  SimpleInterest: "simpleInterests",
  WorkAndTime: "workAndTimes",
  SpeedTimeDistance: "speedTimeDistances",
  MixtureandAlligation: "mixtureandAlligations",
  PipesandCistern: "pipesandCisterns",
  PermutationandCombination: "permutationAndCombinations",
  Random: "randomQuestions",
};

export const getQuestionsByTopic = async (topic) => {
  if (!topicApiMap[topic]) {
    console.error("❌ Unknown topic:", topic);
    return [];
  }

  const endpoint = topicApiMap[topic];
  const url = `${BASE_URL}/api/${endpoint}`;

  console.log("✅ Fetching:", url);

  const res = await fetch(url);

  if (!res.ok) {
    throw new Error(`Failed to fetch ${endpoint}`);
  }

  return res.json();
};
