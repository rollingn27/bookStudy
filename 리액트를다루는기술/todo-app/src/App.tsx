import React, { useCallback, useState, useRef } from 'react';
import './App.css';
import TodoInsert from './todo/TodoInsert';
import TodoList from './todo/TodoList';
import TodoTemplate from './todo/TodoTemplate';
import { todo } from './todo/TodoList';

function App() {
  const initialTodos = [
    { id: 1, text: '리액트 기초 알아보기', checked: true },
    { id: 2, text: '컴포넌트 스타일링해 보기', checked: true },
    { id: 3, text: '일정 관리 앱 만들어 보기', checked: false },
  ];
  const [todos, setTodos] = useState(initialTodos);

  // 고윳값으로 사용될 id
  const nextId = useRef(4);

  const onInsert = useCallback(
    (text: string) => {
      const todo = {
        id: nextId.current,
        text,
        checked: false,
      };

      setTodos(todos.concat(todo));
      nextId.current += 1;
    },
    [todos],
  );

  const onRemove = useCallback(
    (id: number) => {
      setTodos(todos.filter((todo: todo) => todo.id !== id));
    },
    [todos],
  );

  const onToggle = useCallback(
    (id: number) => {
      setTodos(todos.map((todo: todo) => (todo.id === id ? { ...todo, checked: !todo.checked } : todo)));
    },
    [todos],
  );

  return (
    <>
      <TodoTemplate>
        <TodoInsert onInsert={onInsert} />
        <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
      </TodoTemplate>
    </>
  );
}

export default App;
