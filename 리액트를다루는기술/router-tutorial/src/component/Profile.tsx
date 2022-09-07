import { useParams } from 'react-router-dom';

const Profile = () => {
  const { username } = useParams();
  if (username === '') return <div>존재하지 않는 사용자입니다.</div>;
  return (
    <div>
      <h3>{username}</h3>
    </div>
  );
};

export default Profile;
