// Handle form submission
//document.getElementById("signupForm").addEventListener("submit", async (e) => {
//    e.preventDefault();
//    const username = document.getElementById("username").value;
//    const password = document.getElementById("password").value;
//
//    const userData = { username, password };
//
//    try {
//        const response = await fetch('/signup/', {
//            method: 'POST',
//            headers: { 'Content-Type': 'application/json' },
//            body: JSON.stringify(userData)
//        });
//        const result = await response.json();
//        alert(`User ${result.username} registered successfully!`);
//    } catch (error) {
//        console.error('Error:', error);
//    }
//});

// Fetch all users
document.getElementById("fetchUsers").addEventListener("click", async () => {
    try {
        const response = await fetch('/signup/');
        const users = await response.json();
        const userList = document.getElementById("userList");
        userList.innerHTML = '';
        users.forEach(user => {
            const li = document.createElement("li");
            li.textContent = `Username: ${user.username}, Password: ${user.password}`;
            userList.appendChild(li);
        });
    } catch (error) {
        console.error('Error fetching users:', error);
    }
});

// === THREE.JS 3D CUBE ANIMATION ===
function initThreeJS() {
    const container = document.getElementById('threejs-container');
    const scene = new THREE.Scene();
    const camera = new THREE.PerspectiveCamera(75, container.clientWidth / container.clientHeight, 0.1, 1000);
    const renderer = new THREE.WebGLRenderer();
    renderer.setSize(container.clientWidth, container.clientHeight);
    container.appendChild(renderer.domElement);

    // Create a cube
    const geometry = new THREE.BoxGeometry();
    const material = new THREE.MeshBasicMaterial({ color: 0x00ff00, wireframe: true });
    const cube = new THREE.Mesh(geometry, material);
    scene.add(cube);

    camera.position.z = 5;

    // Animation function
    function animate() {
        requestAnimationFrame(animate);
        cube.rotation.x += 0.01;
        cube.rotation.y += 0.01;
        renderer.render(scene, camera);
    }

    animate();

    // Handle resizing
    window.addEventListener('resize', () => {
        camera.aspect = container.clientWidth / container.clientHeight;
        camera.updateProjectionMatrix();
        renderer.setSize(container.clientWidth, container.clientHeight);
    });
}

// Initialize Three.js when the page loads
window.onload = initThreeJS;
