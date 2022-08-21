import './App.css';
import { useState } from 'react';

function App() {
  const name = '리액트';
  const andName = "앤드리액트";
  const unName = undefined;

  // state 값 바꿀때 주의 사항
  // setState 혹은 useState를 통해 전달받은 세터 함수를 사용
  const [object, setObject] = useState({a:1, b: 1});

  // 값을 직업 바꾸면 안됨
  // 예시 object.b = 2;      (x)

  return (
    // 1.if문 대신 조건부 연산자
    // 2.and 조건
    // 3. undefined 렌더링 하지 않기
    // or로 undefined 일때 값 지정해 주기
    
    <>
    <div name="no1">
      {name==="리액트" ?(<h1>리액트입니다.</h1>) : (<h2>리액트가 아닙니다.</h2>)}
    </div>    
    <div name="no2">
      {andName === '리액트' && <h1>리액트 입니다. </h1>}
      
    </div>
    <div name="no3">
    {unName || "리액트"}
    </div>    
    {/* 직접 바꿀 경우 리렌더링이 일어나지 않음. */}
    <div onClick={() => object.a = 5}>
      {object.a}
    </div>
    <div onClick={() => setObject({...object, b:5})}>
      {object.b}
    </div>
    </>
  );
}

export default App;
