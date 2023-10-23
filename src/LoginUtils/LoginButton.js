import { Fragment } from "react";

import { IconButton } from "@mui/material";
import ArrowCircleRightOutlinedIcon from '@mui/icons-material/ArrowCircleRightOutlined';

const LoginButton = ({ children, ...props }) => {
    return (
        <Fragment>
            <IconButton {...props}>
                <ArrowCircleRightOutlinedIcon />
                {children}
            </IconButton>
        </Fragment >);
}
export default LoginButton;