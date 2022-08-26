import React, { CSSProperties } from 'react';
import { MdCheckBoxOutlineBlank, MdCheckBox, MdRemoveCircleOutline } from 'react-icons/md';
import { todo } from './TodoList';
import './TodoListItem.scss';
import cn from 'classnames';

type todoListItemProps = {
  todo: todo;
  onRemove: Function;
  onToggle: Function;
  style: CSSProperties;
};

const TodoListItem = ({ todo, onRemove, onToggle, style }: todoListItemProps) => {
  const { id, text, checked } = todo;
  return (
    <div className="TodoListItem-virtualized" style={style}>
      <div className="TodoListItem">
        <div className={cn('checkbox', { checked })} onClick={() => onToggle(id)}>
          {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
          <div className="text">{text}</div>
        </div>
        <div className="remove" onClick={() => onRemove(id)}>
          <MdRemoveCircleOutline />
        </div>
      </div>
    </div>
  );
};

export default React.memo(TodoListItem);
