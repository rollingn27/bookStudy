import TodoListItem from './TodoListItem';
import './TodoList.scss';

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

export default TodoList;
