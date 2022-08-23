const IterationSample = () => {
  const names = ['눈사람', '얼음', '눈', '바람']
  // index를 key로 사용하면 배열이 변경될 때 효율적으로 리렌더링하지 못함
  const nameList = names.map((name, idx) => <li key={idx}>{name}</li>);
  return (
    <ul>
      {nameList}
    </ul>
  );
}

export default IterationSample;
