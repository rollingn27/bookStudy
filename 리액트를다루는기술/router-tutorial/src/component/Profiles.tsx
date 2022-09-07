import { Link, Route, Routes } from 'react-router-dom';
import Profile from './Profile';

const Profiles = () => {
  return (
    <div>
      <h3>사용자 목록</h3>
      <ul>
        <li>
          <Link to="/profiles/rolling">Rolling</Link>
        </li>
        <li>
          <Link to="/profiles/kim">kim</Link>
        </li>
      </ul>
      <Routes>
        {/* 중첩 라우팅 */}
        <Route path="/*" element={<div>사용자를 선택해주세요.</div>} />
        <Route path=":username" element={<Profile />} />
      </Routes>
    </div>
  );
};

export default Profiles;
