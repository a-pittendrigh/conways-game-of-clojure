import React from "react";
import { storiesOf } from "@storybook/react";

import World from "./World";

export const world = {
  world: [
    [{ state: "dead" }, { state: "dead" }, { state: "dead" }],
    [{ state: "alive" }, { state: "alive" }, { state: "alive" }],
    [{ state: "dead" }, { state: "dead" }, { state: "dead" }]
  ]
};

storiesOf("World", module).add("populated", () => <World {...world} />);
