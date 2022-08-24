import React from 'react';
import './TodoTemplate.scss';

type todoTemplateProps = {
  children: React.ReactNode;
};

const TodoTemplate = ({ children }: todoTemplateProps) => {
  return (
    <>
      <div className="TodoTemplate">
        <div className="app-title">일정관리</div>
        <div className="content">{children}</div>
      </div>
    </>
  );
};

export default TodoTemplate;
