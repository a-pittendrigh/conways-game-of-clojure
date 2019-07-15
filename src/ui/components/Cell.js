import React from "react";

export default function Cell({ state }) {
  return (
    <div className={`cell ${state}`}>
        {state}
    </div>
  );
}
