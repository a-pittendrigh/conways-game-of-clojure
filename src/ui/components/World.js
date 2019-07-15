import React from "react";
import Cell from "./Cell";

export default function World({ world }) {
  return <React.Fragment>
    {world.map(row => row.map(c => <Cell {...c}/>))}
  </React.Fragment>
}
