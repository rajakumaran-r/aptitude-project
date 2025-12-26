const BASE_URL = import.meta.env.VITE_API_URL;

const topicApiMap = {
  Age: "ages",
  ProfitAndLoss: "profitandloss",
  SimpleInterest: "simpleinterest",
  WorkAndTime: "workandtime",
  SpeedTimeDistance: "speedtimedistance",
  MixtureandAlligation: "mixtureandalligation",
  PipesandCistern: "pipesandcisterns",
  PermutationandCombination: "permutationandcombination",
  Random: "random",
};

export const getQuestionsByTopic = async (topic) => {
  const endpoint = topicApiMap[topic];

  if (!endpoint) {
    console.error("❌ Unknown topic:", topic);
    return [];
  }

  const url = `${BASE_URL}/api/${endpoint}`;
  console.log("✅ Fetching:", url);

  const res = await fetch(url);
  if (!res.ok) {
    throw new Error(`Failed to fetch ${endpoint}`);
  }

  return res.json();
};
