from db.operations import OpsForMongo
from dotenv import load_dotenv
import motor.motor_asyncio
import os

load_dotenv()

client = motor.motor_asyncio.AsyncIOMotorClient(f"mongodb://{os.environ['MONGO_USER']}:\
{os.environ['MONGO_PASSWORD']}@{os.environ['MONGO_HOST']}:\
{int(os.environ['MONGO_PORT'])}")

db = client.mflix

def get_movie_ops():
    return OpsForMongo(db, "movies")