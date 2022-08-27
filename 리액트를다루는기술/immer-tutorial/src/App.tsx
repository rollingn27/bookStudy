import React, { useRef, useCallback, useState, ReactEventHandler, ReactHTMLElement } from 'react';
import './App.css';
import produce from 'immer';

type info = {
  id: number;
  name: string;
  username: string;
};

function App() {
  const nextId = useRef(1);
  const initialForm = { name: '', username: '' };
  const initialData = { array: [] as info[], uselessValue: null };
  const [form, setForm] = useState(initialForm);
  const [data, setData] = useState(initialData);

  // input 수정을 위한 함수
  const onChange = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      const { name, value } = e.target;
      // setForm({
      //   ...form,
      //   [name]: [value],
      // });

      // immer 적용
      setForm(
        produce(form, (draft: { [x: string]: string }) => {
          draft[name] = value;
        }),
      );
    },
    [form],
  );

  // form 등록을 위한 함수
  const onSubmit = useCallback(
    (e: React.FormEvent<HTMLFormElement>) => {
      e.preventDefault();
      const info = {
        id: nextId.current,
        name: form.name,
        username: form.username,
      };

      // array에 새 항목 등록
      // setData({
      //   ...data,
      //   array: data.array.concat(info),
      // });
      // immer 적용
      setData(
        produce(data, (draft) => {
          draft.array.push(info);
        }),
      );

      // form 초기화
      setForm({
        name: '',
        username: '',
      });
      nextId.current += 1;
    },
    [data, form.name, form.username],
  );

  // 항목을 삭제하는 함수
  const onRemove = useCallback(
    (id: number) => {
      // setData({
      //   ...data,
      //   array: data.array.filter((info: info) => info.id !== id),
      // });
      setData(
        produce(data, (draft) => {
          draft.array.splice(
            draft.array.findIndex((info) => info.id === id),
            1,
          );
        }),
      );
    },
    [data],
  );

  return (
    <div>
      <form onSubmit={onSubmit}>
        <input name="username" placeholder="아이디" value={form.username} onChange={onChange} />
        <input name="name" placeholder="이름" value={form.name} onChange={onChange} />
        <button type="submit">등록</button>
      </form>
      <div>
        <ul>
          {data.array.map((info: info) => (
            <li key={info.id} onClick={() => onRemove(info.id)}>
              {info.username} ({info.name})
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;
