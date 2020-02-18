import React from 'react';
import { AppContext } from './AppContext';
import Analytics from './Analytics';

const App = () => {

  return (
    <AppContext>
      <Analytics />
    </AppContext>
  );
};

export default App;
