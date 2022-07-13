import * as React from "react";
import "./Post.css";
import { styled } from "@mui/material/styles";
import Card from "@mui/material/Card";
import CardHeader from "@mui/material/CardHeader";
import CardMedia from "@mui/material/CardMedia";
import CardContent from "@mui/material/CardContent";
import CardActions from "@mui/material/CardActions";
import Collapse from "@mui/material/Collapse";
import Avatar from "@mui/material/Avatar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import { red } from "@mui/material/colors";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ShareIcon from "@mui/icons-material/Share";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import { Link } from "react-router-dom";
import OutlinedInput from "@material-ui/core/OutlinedInput";
import { InputAdornment } from "@mui/material";
import Button from "@material-ui/core/Button";

function PostForm(props) {
  const { title, text, userId, userName } = props;
  const [expanded, setExpanded] = React.useState(false);
  const [liked, setLiked] = React.useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  function RecipeReviewCard() {
    handleExpandClick();
  }

  const ExpandMore = styled((props) => {
    const { expand, ...other } = props;
    return <IconButton {...other} />;
  })(({ theme, expand }) => ({
    transform: !expand ? "rotate(0deg)" : "rotate(180deg)",
    marginLeft: "auto",
    transition: theme.transitions.create("transform", {
      duration: theme.transitions.duration.shortest,
    }),
  }));

  const handleLike = () => {
    setLiked(!liked);
  };

  return (
    <div className="postContainer">
      <Card className="postCard">
        <CardHeader
          avatar={
            <Link className="link" to={{ pathname: "/users/" + userId }}>
              <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
                {userName.charAt(0).toUpperCase()}
              </Avatar>
            </Link>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          title={
            <OutlinedInput
              id="outlined-adornment-amount"
              multiline
              placeholder="Title"
              inputProps={{ maxLength: 25 }}
              fullWith
            ></OutlinedInput>
          }
          subheader="September 14, 2016"
        />
        <CardContent>
          <Typography variant="body2" color="text.secondary">
            <OutlinedInput
              id="outlined-adornment-amount"
              multiline
              placeholder="Text"
              inputProps={{ maxLength: 250 }}
              fullWith
              endAdornment={
                <InputAdornment>
                  <Button variant="contained">Post</Button>
                </InputAdornment>
              }
            ></OutlinedInput>
          </Typography>
        </CardContent>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites" onClick={handleLike}>
            <FavoriteIcon style={liked ? { color: "red" } : { color: null }} />
          </IconButton>
          <IconButton aria-label="share">
            <ShareIcon />
          </IconButton>
          <ExpandMore
            expand={expanded}
            onClick={handleExpandClick}
            aria-expanded={expanded}
            aria-label="show more"
          >
            <ExpandMoreIcon />
          </ExpandMore>
        </CardActions>
        <Collapse in={expanded} timeout="auto" unmountOnExit>
          <CardContent></CardContent>
        </Collapse>
      </Card>
    </div>
  );
}

export default PostForm;
