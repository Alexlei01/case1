import * as React from "react";

function IconShadowOff({
  size = 24,
  color = "currentColor",
  stroke = 2,
  ...props
}) {
  return <svg xmlns="http://www.w3.org/2000/svg" className="icon icon-tabler icon-tabler-shadow-off" width={size} height={size} viewBox="0 0 24 24" strokeWidth={stroke} stroke={color} fill="none" strokeLinecap="round" strokeLinejoin="round" {...props}><desc>{"Download more icon variants from https://tabler-icons.io/i/shadow-off"}</desc><path stroke="none" d="M0 0h24v24H0z" fill="none" /><path d="M5.634 5.638a9 9 0 0 0 12.728 12.727m1.68 -2.32a9 9 0 0 0 -12.086 -12.088" /><path d="M16 12h2" /><path d="M13 15h2" /><path d="M13 18h1" /><path d="M13 9h4" /><path d="M13 6h1" /><path d="M3 3l18 18" /></svg>;
}

export default IconShadowOff;