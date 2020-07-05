import React from 'react';
import Header from './components/organisms/Header/Header';
import Footer from './components/organisms/Footer/Footer';

const message: string = 'hello world';
console.log(message);

function App() {
  return (
    <div id="body" className="App">
      <Header name="Jiheon" />
      <h1>Hello World!</h1>
      <Footer name="Jiheon" />
    </div>
  );
}

export default App;
