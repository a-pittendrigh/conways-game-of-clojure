import { configure } from '@storybook/react';

// automatically import all files ending in *.stories.js
const req = require.context('../components', true, /\.stories\.js$/);
function loadStories() {
  req.keys().forEach(filename => { console.log("filename: ", filename); return req(filename) });
}

configure(loadStories, module);
