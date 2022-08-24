import TodoListItem from './TodoListItem';
import './TodoList.scss';
import React from 'react';

export type todo = {
  id: number;
  text: string;
  checked: boolean;
};

type todoListProps = {
  todos: todo[];
  onRemove: Function;
  onToggle: Function;
};

const TodoList = ({ todos, onRemove, onToggle }: todoListProps) => {
  return (
    <div className="TodoList">
      {todos.map((todo: todo) => (
        <TodoListItem todo={todo} key={todo.id} onRemove={onRemove} onToggle={onToggle} />
      ))}
    </div>
  );
};

// 현재는 불필요한 렌더링은 발생하지 않음. 
export default React.memo(TodoList);
