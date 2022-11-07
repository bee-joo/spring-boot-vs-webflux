from dotenv import load_dotenv
from fastapi import FastAPI
from routers import movie
import os
import uvicorn


app = FastAPI()
app.include_router(movie.router)


if __name__ == "__main__":
    load_dotenv()
    uvicorn.run(app, host="0.0.0.0", port=int(os.environ["APP_PORT"]))