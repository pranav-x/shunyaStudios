import { useEffect, useState } from 'react'

export default function App() {
  const [data, setData] = useState([])
  const [loading, setLoading] = useState(true)
  const [err, setErr] = useState(null)

  useEffect(() => {
    fetch('/api/v1/voters', { headers: { Accept: 'application/json' } })
      .then(r => { if (!r.ok) throw new Error(`HTTP ${r.status}`); return r.json() })
      .then(setData)
      .catch(e => setErr(e.message))
      .finally(() => setLoading(false))
  }, [])

  if (loading) return <div style={{padding:16}}>Loading…</div>
  
  if (err) return <div style={{padding:16, color:'crimson'}}>Error: {err}</div>

  return (
    <div style={{padding:24}}>






















      
      <h1>Voter Roll</h1>
      <table style={{borderCollapse:'collapse', width:'100%', maxWidth:960}}>
        <thead>
          <tr>
            {['Serial','House','Name','Rel Type','Rel Name','Gender','Age','Voter ID'].map(h =>
              <th key={h} style={{textAlign:'left', borderBottom:'1px solid #ddd', padding:8}}>{h}</th>
            )}
          </tr>
        </thead>
        <tbody>
          {data.map(v => (
            <tr key={v.serialNo}>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.serialNo}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.houseNo}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.name}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.relationType}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.relationName}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.gender}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0'}}>{v.age}</td>
              <td style={{padding:8, borderBottom:'1px solid #f0f0f0', whiteSpace:'nowrap'}}>{v.voterId}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  )
}
