import { MdAdd } from 'react-icons/md';
import './TodoInsert.scss';
import { useState, useCallback } from 'react';

type todoInsertProps = {
  onInsert: Function;
};

const TodoInsert = ({ onInsert }: todoInsertProps) => {
  const [value, setValue] = useState('');

  const onChange = useCallback((e: React.ChangeEvent<HTMLInputElement>) => {
    setValue(e.target.value);
  }, []);

  const onSubmit = useCallback(
    (e: any) => {
      onInsert(value);
      setValue('');
      // submit은 새로고침 발생
      // 이를 방지
      e.preventDefault();
    },
    [onInsert, value],
  );

  return (
    <form className="TodoInsert" onSubmit={onSubmit}>
      <input placeholder="할 일을 입력하세요" value={value} onChange={onChange} />
      <button type="submit">
        <MdAdd />
      </button>
    </form>
  );
};

export default TodoInsert;
