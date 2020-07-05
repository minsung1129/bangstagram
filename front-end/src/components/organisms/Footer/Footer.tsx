import React from 'react';
import './Footer.css';

type FooterProps = {
  name: string;
};

function Footer({ name }: FooterProps) {
  return <div className="footerBody">Main Footer</div>;
}

export default Footer;
