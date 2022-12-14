import axios from "axios";
import { useEffect, useState } from "react";
import styled from "styled-components";
import NewsItem, { article } from "./NewsItem";

type newsListProps = {
  category?: string;
};

const NewsList = ({ category }: newsListProps) => {
  const [articles, setArticles] = useState<article[]>();
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // async를 사용하는 함수 따로 선언
    const fetchData = async () => {
      setLoading(true);
      try {
        // 카테고리 지정 쿼리
        const query = category === "all" ? "" : `&category=${category}`;
        const response = await axios.get(
          `https://newsapi.org/v2/top-headlines?country=kr${query}&apikey=${process.env.REACT_APP_NEWS_API}`
        );
        setArticles(response.data.articles);
      } catch (e) {
        console.log(e);
      }
      setLoading(false);
    };

    fetchData();
  }, [category]);

  // 로딩중일때
  if (loading) {
    return <NewsListBlock>대기 중...</NewsListBlock>;
  }

  // articles 값이 설정되지 않았을 때
  if (!articles) {
    return null;
  }

  // articles 값이 유효할 때

  return (
    <NewsListBlock>
      {articles.map((article) => (
        <NewsItem key={article.url} article={article} />
      ))}
    </NewsListBlock>
  );
};

export default NewsList;

const NewsListBlock = styled.div`
  box-sizing: border-box;
  padding-bottom: 3rem;
  width: 48rem;
  margin: 0 auto;
  margin-top: 2rem;
  @media screen and (max-width: 48rem) {
    width: 100%;
    padding-left: 1rem;
    padding-right: 1rem;
  }
`;
