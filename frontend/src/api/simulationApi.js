const apiUrl = "http://localhost:8080";

export async function runSimulation(body) {
  console.log(body);
  const res = await fetch(`${apiUrl}/simulation/run`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(body),
  });
  return res.json();
}

export async function listRuns() {
  return fetch(`${apiUrl}/simulation/runs`).then((r) => r.json());
}

export async function getRun(id) {
  return fetch(`${apiUrl}/simulation/runs/${id}`).then((r) => r.json());
}
