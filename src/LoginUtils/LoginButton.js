import Button from "@mui/material/Button";
import { Fragment } from "react";

const LoginButton = () => {
    return (<Fragment>
        <Button
            style={{
                backgroundColor: "#57010b",
                color: "#e0b58a",
                fontFamily: "Arial"
            }}
            sx={{
                mt: 3,
                mb: 2,
            }}
            type="submit"
            fullWidth
        >
            Σύνδεση
        </Button>
    </Fragment >);
}
export default LoginButton;