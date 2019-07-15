import React from 'react';
import { storiesOf } from '@storybook/react';

import Cell from './Cell';

export const cell = {
  state: 'alive'
};

storiesOf('Cell', module)
  .add('alive', () => <Cell { ...cell} />);
