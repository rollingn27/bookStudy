import { useCallback, useState } from "react";
import { Route, Routes } from "react-router-dom";
import Categories from "./components/Categories";
import NewsPage from "./components/NewsPage";

const App = () => {
  // useState 방식으로 카테고리 로직
  // const [category, setCategory] = useState("all");
  // const onSelect = useCallback((category: string) => setCategory(category), []);
  
  return (
    <>
      {/* <Categories category={category} onSelect={onSelect} /> */}
      <Routes>
        <Route path="/:category" element={<NewsPage />} />
        <Route path="/*" element={<NewsPage />} />
      </Routes>
    </>
  );
};

export default App;
