import styled from "styled-components";
import NewsItem from "./NewsItem";

const NewsList = () => {
  const sampleArticle = {
    title: "제목",
    description: "내용",
    url: "https://google.com",
    urlToImage: "https://via.placeholder.com/160",
  };

  return (
    <NewsListBlock>
      <NewsItem article={sampleArticle} />
      <NewsItem article={sampleArticle} />
      <NewsItem article={sampleArticle} />
      <NewsItem article={sampleArticle} />
      <NewsItem article={sampleArticle} />
      <NewsItem article={sampleArticle} />
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
