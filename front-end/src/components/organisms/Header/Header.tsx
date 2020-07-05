import React from 'react';
import './Header.css';

type HeaderProps = {
  name: string;
};

function Header({ name }: HeaderProps) {
  return <div className="headerBody">Main Header</div>;
}

export default Header;
