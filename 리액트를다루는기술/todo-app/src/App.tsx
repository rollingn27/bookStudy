import React, { useCallback, useState, useRef, useReducer } from 'react';
import './App.css';
import TodoInsert from './todo/TodoInsert';
import TodoList from './todo/TodoList';
import TodoTemplate from './todo/TodoTemplate';
import { todo } from './todo/TodoList';

function createBulkTodos() {
  const array = [];
  for (let i = 1; i <= 2500; i++) {
    array.push({
      id: i,
      text: `할 일 ${i}`,
      checked: false,
    });
  }
  return array;
}

type action = {
  type: string;
  todo?: todo;
  id?: number;
};
// 리듀서 적용하기
function todoReducer(todos: todo[], action: action) {
  switch (action.type) {
    case 'INSERT':
      return todos.filter((todo: todo) => todo.id !== action.id);

    case 'REMOVE':
      return todos.filter((todo: todo) => todo.id !== action.id);
    case 'TOGGLE':
      return todos.map((todo: todo) => (todo.id === action.id ? { ...todo, checked: !todo.checked } : todo));
    default:
      return todos;
  }
}

function App() {
  // const initialTodos = [
  //   { id: 1, text: '리액트 기초 알아보기', checked: true },
  //   { id: 2, text: '컴포넌트 스타일링해 보기', checked: true },
  //   { id: 3, text: '일정 관리 앱 만들어 보기', checked: false },
  // ];

  // 더미 데이터 만들기
  // 주의할점
  // const [todos, setTodos] = useState(createBulkTodos()); 이렇게 넣으면 리렌더링 될 때마다 호출함
  // const [todos, setTodos] = useState(createBulkTodos);
  // 리듀서 적용
  const [todos, dispatch] = useReducer(todoReducer, undefined, createBulkTodos);

  // 고윳값으로 사용될 id
  const nextId = useRef(4);

  const onInsert = useCallback((text: string) => {
    const todo: todo = {
      id: nextId.current,
      text,
      checked: false,
    };

    // setTodos((todos) => todos.concat(todo));
    dispatch({ type: 'INSERT' });
    nextId.current += 1;
  }, []);

  const onRemove = useCallback((id: number) => {
    // setTodos((todos) => todos.filter((todo: todo) => todo.id !== id));
    dispatch({ type: 'REMOVE', id });
  }, []);

  const onToggle = useCallback((id: number) => {
    // setTodos((todos) => todos.map((todo: todo) => (todo.id === id ? { ...todo, checked: !todo.checked } : todo)));
    dispatch({ type: 'TOGGLE', id });
  }, []);

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
