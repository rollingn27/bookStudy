import { useState, useEffect } from 'react';

const Info = () => {

  const [name, setName] = useState('');
  const [nickname, setNickname] = useState('');
  // 기본적으로 렌더링 될때마다 실행
  // ,[] 빈 배열 추가하면 업데이트 때는 실행 x
  // 특정 값이 업데이트될 때만 실행하고 싶을때는 배열안에 체크하고 싶은 값을 넣으면 됨
  useEffect(() => {
    console.log('렌더링이 완료되었습니다!');
    console.log({
      name,
      nickname
    });
    // 업데이트 전, 혹은 unmount
    // unmount만 실행하고 싶으면 빈 배열
    return () => {
      console.log('cleanup', name);
    }

  },[]);

  const onChangeName = (e) => {
    setName(e.target.value);    
  };

  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };

  return (
    <div>
      <div>
        <input value={name} onChange={onChangeName} />
        <input value={nickname} onChange={onChangeNickname} />
      </div>
      <div>
        <div>
          <b>이름: </b>{name}          
        </div>
        <div>
          <b>닉네임: </b>{nickname}
        </div>
      </div>
    </div>
  );
}

export default Info;