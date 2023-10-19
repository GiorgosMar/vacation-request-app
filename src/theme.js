import { createTheme } from "@mui/material/styles";


import grey from "@mui/material/colors/grey";
import { orange, red, amber } from "@mui/material/colors";

const theme = () =>
    createTheme({
        palette: {
            primary: {
                main: '#bc4749'
            },
            secondary: {
                main: '#ffffff',
                contrastText: grey[50]
            }
        },
        shape: {
            borderRadius: 20
        }
    });

export default theme;