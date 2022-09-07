import { useNavigate } from 'react-router-dom';

const UseNavigate = () => {
  const navi = useNavigate();

  // 뒤로 가기
  const goBack = () => {
    navi(-1);
  };

  // 홈으로 가기
  const goHome = () => {
    navi('/');
  };
  return (
    <div>
      <button onClick={goBack}>뒤로</button>
      <button onClick={goHome}>홈으로</button>
    </div>
  );
};

export default UseNavigate;
