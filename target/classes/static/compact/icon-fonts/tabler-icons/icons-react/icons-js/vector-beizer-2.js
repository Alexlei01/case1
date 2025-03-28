import * as React from "react";

function IconVectorBeizer2({
  size = 24,
  color = "currentColor",
  stroke = 2,
  ...props
}) {
  return <svg xmlns="http://www.w3.org/2000/svg" className="icon icon-tabler icon-tabler-vector-beizer-2" width={size} height={size} viewBox="0 0 24 24" strokeWidth={stroke} stroke={color} fill="none" strokeLinecap="round" strokeLinejoin="round" {...props}><path stroke="none" d="M0 0h24v24H0z" fill="none" /><rect x={3} y={3} width={4} height={4} rx={1} /><rect x={17} y={17} width={4} height={4} rx={1} /><line x1={7} y1={5} x2={14} y2={5} /><line x1={10} y1={19} x2={17} y2={19} /><circle cx={9} cy={19} r={1} /><circle cx={15} cy={5} r={1} /><path d="M7 5.5a5 6.5 0 0 1 5 6.5a5 6.5 0 0 0 5 6.5" /></svg>;
}

export default IconVectorBeizer2;