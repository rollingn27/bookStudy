import { useState } from 'react';

const IterationSample2 = () => {
  const [names, setNames] = useState([
    { id: 1, text: "눈사람" },
    { id: 2, text: "얼음" },
    { id: 3, text: "눈" },
    { id: 4, text: "바람" }
  ]);

  const [inputText, setInputText] = useState('');
  // 새로운 항목을 추가할 때 사용할 id
  const [nextId, setNextId] = useState(5);

  const onChange = (e) => setInputText(e.target.value);

  // 클릭시 names 하나씩 추가
  const onClick = () => {    
    const nextNames = names.concat({
      id: nextId,
      text: inputText
    });
    setNextId(nextId + 1);
    setNames(nextNames);
    setInputText('');
  }
  
  // 더블 클릭시 제거
  const onRemove = (id) => {
    const nextNames = names.filter(name => name.id !== id);
    setNames(nextNames);
  }

  const namesList = names.map(name => <li key={name.id} onDoubleClick={() => onRemove(name.id)}>{name.text}</li>); 
  
  return (
    <>
      <input value={inputText} onChange={onChange} />
      <button onClick={onClick}>추가</button>
      <ul>
        {namesList}    
      </ul>    
    </>
  );
}

export default IterationSample2;
