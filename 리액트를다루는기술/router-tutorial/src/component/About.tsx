import { useLocation } from 'react-router-dom';

const About = () => {
  const { search } = useLocation();
  const detail = search === '?detail=true';
  return (
    <div>
      <h1>소개</h1>
      <p>이 프로젝트는 리액트 라우터 기초를 실습해 보는 예제 프로젝트입니다.</p>
      {detail && <p>해당 경로로 들어오면 보이는 텍스트입니다</p>}
    </div>
  );
};

export default About;
