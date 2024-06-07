import os
from PIL import Image

def convert_images_to_webp(directory, current_directory):
    for filename in os.listdir(directory):
        if filename.endswith('.jpg') or filename.endswith('.png'):
            image_path = os.path.join(directory, filename)
            image = Image.open(image_path)
            
            webp_filename = os.path.splitext(filename)[0] + '.webp'
            webp_path = os.path.join(current_directory, webp_filename)
       
            image.save(webp_path, 'webp')
            print(f"Converted {filename} to {webp_filename}")

current_directory = os.getcwd()
input = os.path.join(current_directory, "input")

convert_images_to_webp(input, current_directory)