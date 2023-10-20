import { Fragment } from "react";

import IconButton from '@material-ui/core/IconButton';
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