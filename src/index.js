import { ThemeProvider } from "@mui/material/styles";
import { CssBaseline } from "@mui/material";
import ReactDOM from 'react-dom';

import App from "./App";
import theme from "./theme";

const rootElement = document.getElementById("root");
ReactDOM.render(
  <ThemeProvider theme={theme}>
    <CssBaseline />
    <App />
  </ThemeProvider>,
  rootElement
);