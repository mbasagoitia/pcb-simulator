import React from "react";
import { Routes, Route } from "react-router-dom";
import SimulationRunView from "./components/SimulationRunView.jsx";
import SimulationQueryView from "./components/SimulationQueryView.jsx";
import SimulationReportView from "./components/SimulationReportView.jsx";

import "bootstrap-icons/font/bootstrap-icons.css";

function App() {
  return (
    <Routes>
      <Route path="/" element={<SimulationRunView />} />
      <Route path="/runs" element={<SimulationQueryView />} />
      <Route path="/runs/:id" element={<SimulationReportView />} />
    </Routes>
  );
}

export default App;
