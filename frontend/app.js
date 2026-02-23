const API_BASE_URL = "http://localhost:8080/api";

const propertiesGrid = document.getElementById("propertiesGrid");
const emptyState = document.getElementById("emptyState");
const clearFiltersBtn = document.getElementById("clearFiltersBtn");
const searchBtn = document.getElementById("searchBtn");
const chips = document.querySelectorAll(".chip");
const yearSpan = document.getElementById("yearSpan");

const modal = document.getElementById("propertyModal");
const closeModalBtn = document.getElementById("closeModalBtn");
const modalTitle = document.getElementById("modalTitle");
const modalLocation = document.getElementById("modalLocation");
const modalPrice = document.getElementById("modalPrice");
const modalDescription = document.getElementById("modalDescription");
const modalBedrooms = document.getElementById("modalBedrooms");
const modalBathrooms = document.getElementById("modalBathrooms");
const modalArea = document.getElementById("modalArea");
const modalImage = document.querySelector(".modal__image");
const modalPropertyType = document.getElementById("modalPropertyType");
const modalFurnishing = document.getElementById("modalFurnishing");
const modalFloor = document.getElementById("modalFloor");
const modalTotalFloors = document.getElementById("modalTotalFloors");
const modalParking = document.getElementById("modalParking");
const modalLift = document.getElementById("modalLift");
const modalPowerBackup = document.getElementById("modalPowerBackup");
const modalSecurity = document.getElementById("modalSecurity");
const modalFacing = document.getElementById("modalFacing");
const modalAge = document.getElementById("modalAge");
const modalAmenities = document.getElementById("modalAmenities");
const modalNearby = document.getElementById("modalNearby");
const contactForm = document.getElementById("contactForm");
const contactStatus = document.getElementById("contactStatus");

const loginBtn = document.getElementById("loginBtn");
const signupBtn = document.getElementById("signupBtn");
const logoutBtn = document.getElementById("logoutBtn");
const switchAccountBtn = document.getElementById("switchAccountBtn");
const authUserLabel = document.getElementById("authUserLabel");
const authModal = document.getElementById("authModal");
const closeAuthModalBtn = document.getElementById("closeAuthModalBtn");
const authTabLogin = document.getElementById("authTabLogin");
const authTabSignup = document.getElementById("authTabSignup");
const loginForm = document.getElementById("loginForm");
const signupForm = document.getElementById("signupForm");
const loginStatus = document.getElementById("loginStatus");
const signupStatus = document.getElementById("signupStatus");
const listPropertyBtn = document.getElementById("listPropertyBtn");
const listPropertyModal = document.getElementById("listPropertyModal");
const closeListPropertyModalBtn = document.getElementById("closeListPropertyModalBtn");
const listPropertyForm = document.getElementById("listPropertyForm");
const listPropertyStatus = document.getElementById("listPropertyStatus");

let allProperties = [];
let selectedType = "all";

let authState = {
  token: localStorage.getItem("hrs_token"),
  fullName: localStorage.getItem("hrs_fullName"),
  email: localStorage.getItem("hrs_email"),
};

if (yearSpan) {
  yearSpan.textContent = new Date().getFullYear().toString();
}

window.addEventListener("DOMContentLoaded", () => {
  applyAuthStateToUI();
  loadProperties();
});

loginBtn?.addEventListener("click", () => {
  openAuthModal("login");
});

signupBtn?.addEventListener("click", () => {
  openAuthModal("signup");
});

logoutBtn?.addEventListener("click", () => {
  logout();
});

switchAccountBtn?.addEventListener("click", () => {
  openAuthModal("login");
});

closeAuthModalBtn?.addEventListener("click", () => {
  hideAuthModal();
});

authModal?.addEventListener("click", (event) => {
  if (event.target.classList.contains("modal__overlay")) {
    hideAuthModal();
  }
});

authTabLogin?.addEventListener("click", () => switchAuthTab("login"));
authTabSignup?.addEventListener("click", () => switchAuthTab("signup"));

loginForm?.addEventListener("submit", async (event) => {
  event.preventDefault();
  loginStatus.textContent = "Logging in...";
  try {
    const body = {
      email: document.getElementById("loginEmail").value.trim(),
      password: document.getElementById("loginPassword").value.trim(),
    };
    const res = await fetch(API_BASE_URL + "/auth/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await res.json();
    if (!res.ok) {
      throw new Error(typeof data === "string" ? data : "Login failed");
    }
    setAuthState(data);
    loginStatus.textContent = "Logged in successfully.";
    setTimeout(() => {
      hideAuthModal();
      loginForm.reset();
      loginStatus.textContent = "";
    }, 800);
  } catch (err) {
    loginStatus.textContent = err.message;
  }
});

signupForm?.addEventListener("submit", async (event) => {
  event.preventDefault();
  signupStatus.textContent = "Creating your account...";
  try {
    const body = {
      fullName: document.getElementById("signupName").value.trim(),
      email: document.getElementById("signupEmail").value.trim(),
      password: document.getElementById("signupPassword").value.trim(),
    };
    const res = await fetch(API_BASE_URL + "/auth/register", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await res.json();
    if (!res.ok) {
      throw new Error(typeof data === "string" ? data : "Registration failed");
    }
    setAuthState(data);
    signupStatus.textContent = "Account created and logged in.";
    setTimeout(() => {
      hideAuthModal();
      signupForm.reset();
      signupStatus.textContent = "";
    }, 900);
  } catch (err) {
    signupStatus.textContent = err.message;
  }
});

listPropertyBtn?.addEventListener("click", () => {
  openListPropertyModal();
});

closeListPropertyModalBtn?.addEventListener("click", () => {
  hideListPropertyModal();
});

listPropertyModal?.addEventListener("click", (event) => {
  if (event.target.classList.contains("modal__overlay")) {
    hideListPropertyModal();
  }
});

listPropertyForm?.addEventListener("submit", async (event) => {
  event.preventDefault();
  listPropertyStatus.textContent = "Listing your property...";
  
  try {
    const body = {
      title: document.getElementById("listTitle").value.trim(),
      city: document.getElementById("listCity").value.trim(),
      area: document.getElementById("listArea").value.trim(),
      bedrooms: parseInt(document.getElementById("listBedrooms").value),
      bathrooms: parseInt(document.getElementById("listBathrooms").value),
      areaSqft: parseInt(document.getElementById("listAreaSqft").value),
      propertyType: document.getElementById("listPropertyType").value.trim(),
      pricePerMonth: parseFloat(document.getElementById("listPrice").value),
      furnished: document.getElementById("listFurnished").value === "true",
      description: document.getElementById("listDescription").value.trim(),
      imageUrl: document.getElementById("listImageUrl").value.trim() || null,
      floor: document.getElementById("listFloor").value ? parseInt(document.getElementById("listFloor").value) : null,
      totalFloors: document.getElementById("listTotalFloors").value ? parseInt(document.getElementById("listTotalFloors").value) : null,
      parking: document.getElementById("listParking").value ? parseInt(document.getElementById("listParking").value) : null,
      liftAvailable: document.getElementById("listLift").checked,
      powerBackup: document.getElementById("listPowerBackup").checked,
      security: document.getElementById("listSecurity").checked,
      facing: document.getElementById("listFacing").value.trim() || null,
      propertyAge: document.getElementById("listPropertyAge").value ? parseInt(document.getElementById("listPropertyAge").value) : null,
      amenities: document.getElementById("listAmenities").value.trim() || null,
      nearby: document.getElementById("listNearby").value.trim() || null,
      available: true,
      country: "India"
    };

    const headers = { "Content-Type": "application/json" };
    if (authState.token) {
      headers["Authorization"] = "Bearer " + authState.token;
    }

    const res = await fetch(API_BASE_URL + "/properties", {
      method: "POST",
      headers: headers,
      body: JSON.stringify(body),
    });

    const data = await res.json();
    
    if (!res.ok) {
      throw new Error(typeof data === "string" ? data : (data.error || "Failed to list property"));
    }

    listPropertyStatus.textContent = "Property listed successfully!";
    listPropertyForm.reset();
    
    setTimeout(() => {
      hideListPropertyModal();
      listPropertyStatus.textContent = "";
      // Reload properties to show the new listing
      loadProperties();
    }, 1500);
  } catch (err) {
    listPropertyStatus.textContent = err.message;
  }
});

searchBtn?.addEventListener("click", () => {
  loadProperties();
});

clearFiltersBtn?.addEventListener("click", () => {
  document.getElementById("city").value = "";
  document.getElementById("minPrice").value = "";
  document.getElementById("maxPrice").value = "";
  document.getElementById("bedrooms").value = "";
  selectedType = "all";
  chips.forEach((chip) =>
    chip.classList.toggle("chip--active", chip.dataset.type === "all")
  );
  loadProperties();
});

chips.forEach((chip) => {
  chip.addEventListener("click", () => {
    selectedType = chip.dataset.type;
    chips.forEach((c) => c.classList.remove("chip--active"));
    chip.classList.add("chip--active");
    renderProperties();
  });
});

closeModalBtn?.addEventListener("click", () => {
  hideModal();
});

modal?.addEventListener("click", (event) => {
  if (event.target.classList.contains("modal__overlay")) {
    hideModal();
  }
});

contactForm?.addEventListener("submit", (event) => {
  event.preventDefault();
  contactStatus.textContent =
    "Your inquiry has been recorded (frontend demo only).";
  contactForm.reset();
  setTimeout(() => (contactStatus.textContent = ""), 3500);
});

async function loadProperties() {
  const citySelect = document.getElementById("city");
  const cityValue = citySelect.value.trim();
  // Extract city name (before the dash if present)
  const city = cityValue ? cityValue.split(" - ")[0] : "";
  const minPrice = document.getElementById("minPrice").value.trim();
  const maxPrice = document.getElementById("maxPrice").value.trim();
  const bedrooms = document.getElementById("bedrooms").value.trim();

  const params = new URLSearchParams();
  if (city) params.append("city", city);
  if (minPrice) params.append("minPrice", minPrice);
  if (maxPrice) params.append("maxPrice", maxPrice);
  if (bedrooms) params.append("bedrooms", bedrooms);

  try {
    propertiesGrid.innerHTML = createSkeletonCards();
    emptyState.classList.add("hidden");

    const url =
      API_BASE_URL + "/properties" + (params.toString() ? `?${params}` : "");

    const headers = {};
    if (authState.token) {
      headers["Authorization"] = "Bearer " + authState.token;
    }

    const response = await fetch(url, { headers });

    if (!response.ok) {
      throw new Error("Failed to load properties");
    }

    allProperties = await response.json();
    renderProperties();
  } catch (error) {
    console.error(error);
    allProperties = getFallbackProperties();
    renderProperties(true);
  }
}

function renderProperties(isFallback = false) {
  let list = [...allProperties];

  if (selectedType !== "all") {
    list = list.filter(
      (p) =>
        p.propertyType &&
        p.propertyType.toLowerCase() === selectedType.toLowerCase()
    );
  }

  if (list.length === 0) {
    propertiesGrid.innerHTML = "";
    emptyState.classList.remove("hidden");
    return;
  }

  emptyState.classList.add("hidden");
  propertiesGrid.innerHTML = "";

  list.forEach((property) => {
    const card = document.createElement("article");
    card.className = "property-card";
    card.innerHTML = createPropertyCardHTML(property, isFallback);
    card.addEventListener("click", () => openModal(property));
    propertiesGrid.appendChild(card);
  });
}

function createSkeletonCards() {
  return Array.from({ length: 6 })
    .map(
      () => `
      <article class="property-card" style="pointer-events:none;opacity:0.7;">
        <div class="property-card__image" style="
          background: linear-gradient(90deg, #0f172a 0, #1f2937 50%, #0f172a 100%);
          background-size: 200% 100%;
          animation: shimmer 1.2s infinite;
        "></div>
        <div class="property-card__body">
          <div style="height: 16px; margin-bottom: 6px; background:#111827;border-radius:6px;"></div>
          <div style="height: 12px; width:70%; margin-bottom:10px; background:#020617;border-radius:6px;"></div>
          <div style="height: 12px; width:40%; background:#020617;border-radius:6px;"></div>
        </div>
      </article>
    `
    )
    .join("");
}

function createPropertyCardHTML(property, isFallback) {
  const imageUrl =
    property.imageUrl ||
    (isFallback ? property.fallbackImageUrl : undefined) ||
    "https://images.pexels.com/photos/271643/pexels-photo-271643.jpeg?auto=compress&cs=tinysrgb&w=1200";

  const price =
    property.pricePerMonth != null
      ? `₹${Number(property.pricePerMonth).toLocaleString()} / month`
      : "Price on request";

  const title = property.title || property.name || "Premium rental home";
  const city = property.city || "Unknown city";
  const country = property.country || "";
  const location = country ? `${city}, ${country}` : city;
  const bedrooms = property.bedrooms ?? "—";
  const bathrooms = property.bathrooms ?? "—";
  const area = property.areaSqft ?? property.area ?? "—";
  const typeLabel =
    (property.propertyType &&
      property.propertyType.charAt(0).toUpperCase() +
        property.propertyType.slice(1)) ||
    "Home";

  return `
    <div class="property-card__image" style="background-image:url('${imageUrl}');"></div>
    <span class="property-card__badge">${typeLabel}</span>
    <div class="property-card__body">
      <h3 class="property-card__title">${escapeHtml(title)}</h3>
      <p class="property-card__location">${escapeHtml(location)}</p>
      <div class="property-card__meta">
        <span class="property-card__price">${price}</span>
        <span class="property-card__pill">
          ${bedrooms} bd • ${bathrooms} ba • ${area} sqft
        </span>
      </div>
      <div class="property-card__footer">
        <span>${property.furnished ? "Furnished" : "Unfurnished"}</span>
        <span class="property-card__tag">${
          property.available ? "Available now" : "Coming soon"
        }</span>
      </div>
    </div>
  `;
}

function openModal(property) {
  const title = property.title || property.name || "Premium rental home";
  const city = property.city || "Unknown city";
  const country = property.country || "";
  const areaName = property.area || property.areaName || "";
  const location = areaName ? `${areaName}, ${city}` : (country ? `${city}, ${country}` : city);
  const price =
    property.pricePerMonth != null
      ? `₹${Number(property.pricePerMonth).toLocaleString()} / month`
      : "Price on request";
  const description =
    property.description ||
    "Spacious, well-lit home with excellent connectivity and amenities.";
  const imageUrl =
    property.imageUrl ||
    property.fallbackImageUrl ||
    "https://images.pexels.com/photos/259588/pexels-photo-259588.jpeg?auto=compress&cs=tinysrgb&w=1200";

  const bedrooms = property.bedrooms ?? "—";
  const bathrooms = property.bathrooms ?? "—";
  const area = property.areaSqft ?? property.area ?? "—";

  // Basic info
  modalTitle.textContent = title;
  modalLocation.textContent = location;
  modalPrice.textContent = price;
  modalDescription.textContent = description;
  modalBedrooms.textContent = `${bedrooms} bedrooms`;
  modalBathrooms.textContent = `${bathrooms} bathrooms`;
  modalArea.textContent = `${area} sqft area`;
  modalImage.style.backgroundImage = `url('${imageUrl}')`;

  // Specifications
  modalPropertyType.textContent = property.propertyType 
    ? property.propertyType.charAt(0).toUpperCase() + property.propertyType.slice(1)
    : "—";
  modalFurnishing.textContent = property.furnished ? "Furnished" : (property.furnished === false ? "Unfurnished" : "—");
  modalFloor.textContent = property.floor != null ? `Floor ${property.floor}` : "—";
  modalTotalFloors.textContent = property.totalFloors != null ? `${property.totalFloors} floors` : "—";
  modalParking.textContent = property.parking != null ? `${property.parking} ${property.parking === 1 ? 'space' : 'spaces'}` : (property.parkingAvailable ? "Available" : "—");
  modalLift.textContent = property.liftAvailable !== undefined ? (property.liftAvailable ? "Available" : "Not available") : "—";
  modalPowerBackup.textContent = property.powerBackup !== undefined ? (property.powerBackup ? "Available" : "Not available") : "—";
  modalSecurity.textContent = property.security !== undefined ? (property.security ? "24/7 Security" : "No security") : "—";
  modalFacing.textContent = property.facing || "—";
  modalAge.textContent = property.propertyAge != null ? `${property.propertyAge} years` : "—";

  // Amenities - handle both array and comma-separated string
  let amenities = [];
  if (property.amenities) {
    if (Array.isArray(property.amenities)) {
      amenities = property.amenities;
    } else if (typeof property.amenities === 'string') {
      amenities = property.amenities.split(',').map(a => a.trim()).filter(a => a);
    }
  } else if (property.amenitiesList) {
    amenities = Array.isArray(property.amenitiesList) ? property.amenitiesList : [];
  }
  
  if (amenities.length > 0) {
    modalAmenities.innerHTML = amenities.map(amenity => 
      `<span class="amenity-tag">${escapeHtml(amenity)}</span>`
    ).join("");
  } else {
    modalAmenities.innerHTML = '<span class="amenity-tag">WiFi</span><span class="amenity-tag">Water Supply</span><span class="amenity-tag">Electricity</span>';
  }

  // Nearby locations - handle both array and comma-separated string
  let nearby = [];
  if (property.nearby) {
    if (Array.isArray(property.nearby)) {
      nearby = property.nearby;
    } else if (typeof property.nearby === 'string') {
      // Parse "Name - Distance" format
      nearby = property.nearby.split(',').map(n => {
        const parts = n.trim().split(' - ');
        return parts.length === 2 ? { name: parts[0].trim(), distance: parts[1].trim() } : { name: n.trim() };
      }).filter(n => n.name);
    }
  } else if (property.nearbyLocations) {
    nearby = Array.isArray(property.nearbyLocations) ? property.nearbyLocations : [];
  }
  
  if (nearby.length > 0) {
    modalNearby.innerHTML = nearby.map(loc => {
      const name = typeof loc === 'string' ? loc : (loc.name || loc);
      const distance = typeof loc === 'object' && loc.distance ? loc.distance : '';
      return `<div class="nearby-item">
        <span class="nearby-name">${escapeHtml(name)}</span>
        ${distance ? `<span class="nearby-distance">${escapeHtml(distance)}</span>` : ''}
      </div>`;
    }).join("");
  } else {
    modalNearby.innerHTML = '<div class="nearby-item"><span class="nearby-name">Metro Station</span><span class="nearby-distance">500m</span></div><div class="nearby-item"><span class="nearby-name">Shopping Mall</span><span class="nearby-distance">1.2km</span></div>';
  }

  modal.classList.remove("hidden");
  document.body.style.overflow = "hidden";
}

function hideModal() {
  modal.classList.add("hidden");
  document.body.style.overflow = "";
}

function escapeHtml(str) {
  if (!str) return "";
  return String(str)
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;")
    .replace(/'/g, "&#039;");
}

function getFallbackProperties() {
  return [
    {
      id: 1,
      title: "Skyline View Apartment",
      city: "Bangalore",
      area: "Koramangala",
      country: "India",
      pricePerMonth: 42000,
      bedrooms: 2,
      bathrooms: 2,
      areaSqft: 980,
      propertyType: "apartment",
      furnished: true,
      available: true,
      floor: 5,
      totalFloors: 12,
      parking: 1,
      liftAvailable: true,
      powerBackup: true,
      security: true,
      facing: "East",
      propertyAge: 3,
      description: "Beautiful 2BHK apartment with modern amenities, located in the heart of Koramangala. Perfect for working professionals with excellent connectivity.",
      amenities: ["WiFi", "AC", "Modular Kitchen", "Swimming Pool", "Gym", "Parking", "24/7 Security", "Power Backup"],
      nearby: [
        { name: "Metro Station", distance: "800m" },
        { name: "Shopping Mall", distance: "1.5km" },
        { name: "Hospital", distance: "2km" },
        { name: "School", distance: "1.2km" }
      ],
      fallbackImageUrl:
        "https://images.pexels.com/photos/439391/pexels-photo-439391.jpeg?auto=compress&cs=tinysrgb&w=1200",
    },
    {
      id: 2,
      title: "Modern Family Home",
      city: "Pune",
      area: "Hinjewadi",
      country: "India",
      pricePerMonth: 35000,
      bedrooms: 3,
      bathrooms: 3,
      areaSqft: 1450,
      propertyType: "house",
      furnished: false,
      available: true,
      floor: 2,
      totalFloors: 3,
      parking: 2,
      liftAvailable: false,
      powerBackup: true,
      security: true,
      facing: "North",
      propertyAge: 5,
      description: "Spacious 3BHK independent house in a peaceful neighborhood. Ideal for families looking for comfort and privacy.",
      amenities: ["WiFi", "Water Supply", "Electricity", "Garden", "Parking", "Security"],
      nearby: [
        { name: "IT Park", distance: "2km" },
        { name: "Supermarket", distance: "1km" },
        { name: "School", distance: "800m" }
      ],
      fallbackImageUrl:
        "https://images.pexels.com/photos/32870/pexels-photo.jpg?auto=compress&cs=tinysrgb&w=1200",
    },
    {
      id: 3,
      title: "Luxury Villa with Pool",
      city: "Mumbai",
      area: "Bandra",
      country: "India",
      pricePerMonth: 95000,
      bedrooms: 4,
      bathrooms: 4,
      areaSqft: 2600,
      propertyType: "villa",
      furnished: true,
      available: false,
      floor: 1,
      totalFloors: 2,
      parking: 3,
      liftAvailable: false,
      powerBackup: true,
      security: true,
      facing: "South",
      propertyAge: 2,
      description: "Premium 4BHK villa with private pool and modern interiors. Located in one of Mumbai's most sought-after areas.",
      amenities: ["WiFi", "AC", "Swimming Pool", "Gym", "Garden", "Parking", "24/7 Security", "Power Backup", "Modular Kitchen"],
      nearby: [
        { name: "Beach", distance: "500m" },
        { name: "Shopping Complex", distance: "1km" },
        { name: "Airport", distance: "8km" }
      ],
      fallbackImageUrl:
        "https://images.pexels.com/photos/2102587/pexels-photo-2102587.jpeg?auto=compress&cs=tinysrgb&w=1200",
    },
  ];
}

const shimmerStyle = document.createElement("style");
shimmerStyle.textContent = `
@keyframes shimmer {
  0% { background-position: -200% 0; }
  100% { background-position: 200% 0; }
}`;
document.head.appendChild(shimmerStyle);

function openAuthModal(tab) {
  authModal.classList.remove("hidden");
  document.body.style.overflow = "hidden";
  switchAuthTab(tab);
  // Clear any previous error messages
  if (loginStatus) loginStatus.textContent = "";
  if (signupStatus) signupStatus.textContent = "";
}

function hideAuthModal() {
  authModal.classList.add("hidden");
  document.body.style.overflow = "";
}

function switchAuthTab(tab) {
  const isLogin = tab === "login";
  authTabLogin.classList.toggle("auth-tab--active", isLogin);
  authTabSignup.classList.toggle("auth-tab--active", !isLogin);
  loginForm.classList.toggle("hidden", !isLogin);
  signupForm.classList.toggle("hidden", isLogin);
}

function setAuthState(data) {
  authState = {
    token: data.token,
    fullName: data.fullName,
    email: data.email,
  };
  localStorage.setItem("hrs_token", authState.token);
  localStorage.setItem("hrs_fullName", authState.fullName);
  localStorage.setItem("hrs_email", authState.email);
  applyAuthStateToUI();
}

function logout() {
  authState = {
    token: null,
    fullName: null,
    email: null,
  };
  localStorage.removeItem("hrs_token");
  localStorage.removeItem("hrs_fullName");
  localStorage.removeItem("hrs_email");
  applyAuthStateToUI();
}

function openListPropertyModal() {
  listPropertyModal.classList.remove("hidden");
  document.body.style.overflow = "hidden";
  listPropertyStatus.textContent = "";
}

function hideListPropertyModal() {
  listPropertyModal.classList.add("hidden");
  document.body.style.overflow = "";
}

function applyAuthStateToUI() {
  const isLoggedIn = !!authState.token;
  if (authUserLabel) {
    if (isLoggedIn) {
      authUserLabel.textContent = `Hi, ${authState.fullName || "User"}`;
      authUserLabel.classList.remove("hidden");
    } else {
      authUserLabel.textContent = "";
      authUserLabel.classList.add("hidden");
    }
  }
  if (loginBtn) loginBtn.style.display = isLoggedIn ? "none" : "inline-flex";
  if (signupBtn) signupBtn.style.display = isLoggedIn ? "none" : "inline-flex";
  if (logoutBtn) {
    logoutBtn.style.display = isLoggedIn ? "inline-flex" : "none";
    logoutBtn.classList.toggle("hidden", !isLoggedIn);
  }
  if (switchAccountBtn) {
    switchAccountBtn.style.display = isLoggedIn ? "inline-flex" : "none";
    switchAccountBtn.classList.toggle("hidden", !isLoggedIn);
  }
}

