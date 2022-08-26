import TodoListItem from './TodoListItem';
import './TodoList.scss';
import React, { CSSProperties, useCallback } from 'react';
import { List } from 'react-virtualized';

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

type list = {
  index: number;
  key: string;
  style: CSSProperties;
};
const TodoList = ({ todos, onRemove, onToggle }: todoListProps) => {
  const rowRenderer = useCallback(
    ({ index, key, style }: list) => {
      const todo = todos[index];
      return <TodoListItem todo={todo} key={key} onRemove={onRemove} onToggle={onToggle} style={style} />;
    },
    [onRemove, onToggle, todos],
  );

  return (
    <>
      <List
        className="TodoList"
        width={512}
        height={513}
        rowCount={todos.length}
        rowHeight={57}
        rowRenderer={rowRenderer}
        list={todos}
        style={{ outline: 'none' }}
      />
    </>
  );
};

// 현재는 불필요한 렌더링은 발생하지 않음.
export default React.memo(TodoList);
